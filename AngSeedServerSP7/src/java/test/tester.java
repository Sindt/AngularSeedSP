/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.User;
import facades.UserFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sindt
 */
public class tester {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AngSeedServerPU");
    private static UserFacade facade = new UserFacade(emf);

    public static void main(String[] args) {

        User u = new User();
        u.setUserName("user");
        u.setPassword("test");
        u.AddRole("user");
        User user = facade.addUser(u);

        System.out.println(user.getUserName() + " WIN !");

    }

}
