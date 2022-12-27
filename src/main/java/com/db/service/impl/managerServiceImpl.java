package com.db.service.impl;

import com.db.mapper.*;
import com.db.pojo.*;
import com.db.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description: 实现类
 * @Author: xw
 * @Date: 2022/12/6 20:31
 */
@Service
@Transactional
public class managerServiceImpl implements managerService {
    @Autowired
    private managerMapper managerCorrect;

    @Autowired
    private onlineuserMapper onlineuserCheck;

    @Autowired
    private storeMapper storeF;

    @Autowired
    private subscribeMapper order;

    @Autowired
    private allfoodMapper allfood;

    /*自定义的查询*/
    @Autowired
    private personalmapper pe;

    /*订单信息查询*/
    @Autowired
    private subscribesMapper subs;

    /*店铺账户管理*/
    @Autowired
    private ownerMapper keeper;

    /*店铺库存*/
    @Autowired
    private storestockMapper ssm;

    /*商铺现金*/
    @Autowired
    private storecashMapper cash;

    /*公司管理人员信息检验*/
    @Override
    public boolean verifyManager(String user, String password) {
        managerExample managerEx = new managerExample();
        managerEx.createCriteria().andManagernameEqualTo(user).andPasswordEqualTo(password);
        List<manager> managers = managerCorrect.selectByExample(managerEx);
        return !managers.isEmpty();
    }

    /*线上用户登录信息检验*/
    @Override
    public boolean verifyOnlineUser(String username, String password) {
        onlineuserExample onlineuser = new onlineuserExample();
        onlineuser.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<com.db.pojo.onlineuser> list = onlineuserCheck.selectByExample(onlineuser);
        return !list.isEmpty();
    }

    /*添加线上线上用户*/
    @Override
    public void insertOnlineUser(onlineuser newUser) {
        int value = onlineuserCheck.insert(newUser);
        System.out.println("value = " + value);
    }

    /*查找线上用户所在地的商品*/
    @Override
    public List<foodDisplay1> selectIpProduct(String username) {
        onlineuserExample onlineuserEx = new onlineuserExample();
        onlineuserEx.createCriteria().andUsernameEqualTo(username);
        List<onlineuser> onlineusers = onlineuserCheck.selectByExample(onlineuserEx);
        String ip = onlineusers.get(0).getIp();
        storeExample storeEx = new storeExample();
        storeEx.createCriteria().andIpEqualTo(ip);
        List<store> stores = storeF.selectByExample(storeEx);
        store store = stores.get(0);
        int ownerid = store.getOwnerid();
        List<foodDisplay1> allUserByIp = pe.getAllUserByIp(ownerid);
        return allUserByIp;
    }

    /*线上购物界面添加的订单*/
    @Override
    public void insertSubscribe(cartUser1 food) {
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(food.getName());
        List<allfood> allfoods = allfood.selectByExample(allfoodEx);
        int id = allfoods.get(0).getId();
        subscribe u = new subscribe();
        u.setUsername(food.getUsing());
        u.setFoodid(id);
        u.setQuality(Character.toString(food.getQuality()));
        u.setNumber(1);
        subscribeExample subscribeEx = new subscribeExample();
        subscribeKey Key = new subscribeKey();
        Key.setFoodid(id);
        Key.setQuality(Character.toString(food.getQuality()));
        Key.setUsername(food.getUsing());
        subscribe sub = order.selectByPrimaryKey(Key);

        if (sub != null) {
            sub.setNumber(sub.getNumber() + 1);
            order.updateByPrimaryKey(sub);
            return;
        }
        order.insert(u);
    }

    /*显示线上用户的订单*/
    @Override
    public List<completeCart1> displayCart(String using) {
        List<completeCart1> completeCart1s = subs.allSubscribes(using);
        completeCart1s.removeIf(t -> t.getNumber() == 0);
        pe.deleteUnuseful();
        return completeCart1s;
    }

    /*线上用户删除订单*/
    @Override
    public void deleteS(String username, String name, char quality) {
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(name);
        List<com.db.pojo.allfood> allfoods = allfood.selectByExample(allfoodEx);
        allfood allfood1 = allfoods.get(0);
        Integer id = allfood1.getId();
        subscribeExample subscribeEx = new subscribeExample();
        subscribeEx.createCriteria().andFoodidEqualTo(id)
                .andUsernameEqualTo(username).andQualityEqualTo(Character.toString(quality));
        order.deleteByExample(subscribeEx);
    }

    /*线上用户减少订单*/
    @Override
    public void subtractOne(ByThis1 by) {
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(by.getName());
        List<com.db.pojo.allfood> allfoods = allfood.selectByExample(allfoodEx);
        com.db.pojo.allfood allfood1 = allfoods.get(0);
        Integer id = allfood1.getId();
        subscribeKey Key = new subscribeKey();
        Key.setUsername(by.getUsername());
        Key.setQuality(by.getQuality());
        Key.setFoodid(id);
        subscribe sub = order.selectByPrimaryKey(Key);
        if (sub.getNumber() > 0) {
            sub.setNumber(sub.getNumber() - 1);
            order.updateByPrimaryKey(sub);
        }
    }

    /*线上线上用户增加订单*/
    @Override
    public void addOne(ByThis1 by) {
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(by.getName());
        List<com.db.pojo.allfood> allfoods = allfood.selectByExample(allfoodEx);
        com.db.pojo.allfood allfood1 = allfoods.get(0);
        Integer id = allfood1.getId();
        subscribeKey Key = new subscribeKey();
        Key.setUsername(by.getUsername());
        Key.setQuality(by.getQuality());
        Key.setFoodid(id);
        subscribe sub = order.selectByPrimaryKey(Key);
        sub.setNumber(sub.getNumber() + 1);
        order.updateByPrimaryKey(sub);
    }

    /*登陆账户并查找自己店铺的库存*/
    @Override
    public List<keeperByThis> Keeper(String username, String password) {
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<owner> owners = keeper.selectByExample(ownerEx);
        if (owners.size() == 0) return null;
        return pe.showForKeeper(owners.get(0).getId());
    }

    /*搜索食品*/
    @Override
    public List<foodDisplay1> searchFood(String name, String username) {
        List<foodDisplay1> result = pe.searchFood(name, username);
        return result;
    }

    /*删除这条货物*/
    @Override
    public void deleteThis(ByThis1 by) {
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(by.getUsername());
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(by.getName());
        storestockExample storestockEx = new storestockExample();
        storestockEx.createCriteria().andOwneridEqualTo(keeper.selectByExample(ownerEx).get(0).getId())
                .andIdEqualTo(allfood.selectByExample(allfoodEx).get(0).getId()).andQualityEqualTo(by.getQuality());
        ssm.deleteByExample(storestockEx);
    }

    /*库存减少一份*/
    @Override
    public void deleteA(ByThis1 by) {
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(by.getUsername());
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(by.getName());
        storestockExample storestockEx = new storestockExample();
        storestockEx.createCriteria().andOwneridEqualTo(keeper.selectByExample(ownerEx).get(0).getId())
                .andIdEqualTo(allfood.selectByExample(allfoodEx).get(0).getId()).andQualityEqualTo(by.getQuality());
        storestock a = ssm.selectByExample(storestockEx).get(0);
        if (a.getNumber() - 1 == 0) ssm.deleteByExample(storestockEx);
        else {
            a.setNumber(a.getNumber() - 1);
            ssm.updateByPrimaryKey(a);
        }
    }

    /*库存减少一份*/
    @Override
    public void addA(ByThis1 by) {
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(by.getUsername());
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(by.getName());
        storestockExample storestockEx = new storestockExample();
        storestockEx.createCriteria().andOwneridEqualTo(keeper.selectByExample(ownerEx).get(0).getId())
                .andIdEqualTo(allfood.selectByExample(allfoodEx).get(0).getId()).andQualityEqualTo(by.getQuality());
        storestock a = ssm.selectByExample(storestockEx).get(0);

        a.setNumber(a.getNumber() + 1);
        ssm.updateByPrimaryKey(a);
    }

    /*找出对应货品*/
    @Override
    public List<byCash1> intoMoney(String username) {
        return pe.showForCash(username);
    }

    /*找出对应的钱*/
    @Override
    public Double sortMoney(String username) {
        return pe.cash(username);
    }

    /*用制作返回页面查找库存信息*/
    @Override
    public List<keeperByThis> Keeper(String username) {
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(username);
        List<owner> owners = keeper.selectByExample(ownerEx);
        return pe.showForKeeper(owners.get(0).getId());
    }

    /*收银*/
    @Override
    public void sortCash(sortMoney1 money1) {
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(money1.getName());
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(money1.getUsername());
        storestockExample storestockEx = new storestockExample();
        Integer id = keeper.selectByExample(ownerEx).get(0).getId();
        storestockEx.createCriteria().andQualityEqualTo(money1.getQuality())
                .andIdEqualTo(allfood.selectByExample(allfoodEx).get(0).getId())
                .andOwneridEqualTo(id);
        storestock s = ssm.selectByExample(storestockEx).get(0);
        s.setNumber(s.getNumber() - money1.getNumber());
        ssm.updateByPrimaryKey(s);
        Double cash1 = pe.cash(money1.getUsername());
        storecash st = new storecash();
        pe.addCash(id, cash1 + money1.getNumber() * s.getOutprice());
    }

    /*更新商店库存信息*/
    @Override
    public void updateStock(changeByThis1 by) {
        if (by.getUsername() == null) return;
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(by.getUsername());
        owner ow = keeper.selectByExample(ownerEx).get(0);
        if (ow == null) return;
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(by.getName());
        Integer id = allfood.selectByExample(allfoodEx).get(0).getId();
        if (id == null) return;
        storestockExample storestockEx = new storestockExample();
        storestockEx.createCriteria().andOwneridEqualTo(ow.getId())
                .andIdEqualTo(id).andQualityEqualTo(by.getQuality());
        storestock s = ssm.selectByExample(storestockEx).get(0);
        s.setNumber(by.getNumber());
        s.setOutprice(by.getOutprice());
        s.setInprice(by.getInprice());
        ssm.updateByPrimaryKey(s);
    }

    /*返回所有食物信息*/
    @Override
    public List<com.db.pojo.allfood> allFood() {
        return pe.allFoodInfo();
    }

    /*进货*/
    @Override
    public void intoStore(intoFoodBy1 by) {
        allfoodExample allfoodEx = new allfoodExample();
        allfoodEx.createCriteria().andNameEqualTo(by.getName());
        Integer id = allfood.selectByExample(allfoodEx).get(0).getId();
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(by.getUsername());
        Integer Oid = keeper.selectByExample(ownerEx).get(0).getId();
        storestock storeFood = new storestock();
        storeFood.setId(id);
        storeFood.setOwnerid(Oid);
        storeFood.setQuality(by.getQuality());
        storeFood.setInprice(by.getInprice());
        storeFood.setOutprice(by.getOutprice());
        storeFood.setNumber(by.getNumber());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            storeFood.setStart(format.parse(by.getDate()));
        } catch (ParseException e) {
            System.err.println("日期转化格式错误");
            e.printStackTrace();
        }
        ssm.insert(storeFood);
    }

    @Override
    public void insertKeeper(newKeeper1 by) {
        pe.newKeeper(by.getUsername(), by.getPassword());
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andUsernameEqualTo(by.getUsername());
        Integer id = keeper.selectByExample(ownerEx).get(0).getId();
        store s = new store();
        s.setId(id);
        s.setIp(by.getIp());
        s.setOwnerid(id);
        storeF.insert(s);
    }

    @Override
    public List<onlineSub1> showSub(String username) {
        List<onlineSub1> r = pe.showSub(username);
        if (r.size() != 0) {
            r.forEach(s -> s.setAll(s.getNumber() * s.getOutprice()));
        }
        if (r.size() == 0) return null;
        else return r;
    }

    @Override
    public List<keeperInfo> showKeeper() {
        return pe.keepers();
    }

    @Override
    public void updateKeeper(Integer id, String username, String password, String ip) {
        storeExample storeEx = new storeExample();
        storeEx.createCriteria().andIpEqualTo("ip");
        List<store> stores = storeF.selectByExample(storeEx);
        if (stores.size() != 0) return;
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andIdEqualTo(id);
        List<owner> owners = keeper.selectByExample(ownerEx);
        if (owners.size() == 0) return;
        pe.updateOwner(id, username, password, ip);
    }

    @Override
    public void deleteKeeper(Integer id) {
        ownerExample ownerEx = new ownerExample();
        ownerEx.createCriteria().andIdEqualTo(id);
        keeper.deleteByExample(ownerEx);
        storestockExample storestockEx = new storestockExample();
        storestockEx.createCriteria().andOwneridEqualTo(id);
        ssm.deleteByExample(storestockEx);
        storeExample storeEx = new storeExample();
        storeEx.createCriteria().andOwneridEqualTo(id);
        storeF.deleteByExample(storeEx);
    }

    @Override
    public List<storeForCom1> showStore() {
        return pe.stores();
    }

    @Override
    public List<usersForCom1> showUsers() {
        return pe.Users();
    }

    @Override
    public void updateUU(onlineuser o) {
        onlineuserCheck.updateByPrimaryKey(o);
    }

    @Override
    public void deleteUsers(String username) {
        onlineuserCheck.deleteByPrimaryKey(username);
    }
}





















