package com.hbn.study.mongodblearning.dynamicproxy;

/**
 * @ClassNmae UserManagerImpl
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/9 16:26
 * @Version 1.0
 */
public class UserManagerImpl implements   UserManager {
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: "+userName+" password: "+password);
    }
    //重写删除用户方法
    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: "+userName);
    }

}
