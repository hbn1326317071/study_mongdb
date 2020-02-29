package com.hbn.study.mongodblearning.dynamicproxy;

/**
 * @ClassNmae UserManager
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/9 16:25
 * @Version 1.0
 */
public interface UserManager {
    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    void delUser(String userName);

}
