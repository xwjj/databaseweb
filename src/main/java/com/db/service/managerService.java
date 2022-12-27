package com.db.service;

import com.db.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * @Description: 总经理
 * @Author: xw
 * @Date: 2022/12/6 20:29
 */
public interface managerService {

    boolean verifyManager(String user, String password);

    boolean verifyOnlineUser(String username, String password);

    void insertOnlineUser(onlineuser newUser);

    List<foodDisplay1> selectIpProduct(String username);

    void insertSubscribe(cartUser1 food);

    List<completeCart1> displayCart(String using);

    void deleteS(String username, String name, char quality);

    void subtractOne(ByThis1 by);

    void addOne(ByThis1 by);

    List<keeperByThis> Keeper(String username, String password);

    List<foodDisplay1> searchFood(String name, String username);

    void deleteThis(ByThis1 by);

    void deleteA(ByThis1 by);

    /*库存减少一份*/
    void addA(ByThis1 by);

    List<byCash1> intoMoney(String username);

    Double sortMoney(String username);

    void sortCash(sortMoney1 money1);

    List<keeperByThis> Keeper(String username);

    void updateStock(changeByThis1 by);

    List<allfood> allFood();

    void intoStore(intoFoodBy1 by);

    void insertKeeper(newKeeper1 by);

    List<onlineSub1> showSub(String username);

    List<keeperInfo> showKeeper();

    void updateKeeper(Integer id, String username, String password, String ip);

    void deleteKeeper(Integer id);

    List<storeForCom1> showStore();

    List<usersForCom1> showUsers();

    void updateUU(onlineuser o);

    void deleteUsers(String username);
}
