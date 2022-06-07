package com.stackroute.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.Model.AuthenticationServiceModel;
import com.stackroute.Repository.AuthenticationServiceRepository;

@Service
public class AuthenticationServiceInterfaceImpl implements AuthenticationServiceInterface {


    @Autowired
    AuthenticationServiceRepository authenticationServiceRepositoryObj;


    public ResponseEntity<Object> gettingAll() throws UserNotFoundException {
        if (authenticationServiceRepositoryObj.count() == 0) {
            throw new UserNotFoundException("There are no existing users,consider to add new users");
        }
        return new ResponseEntity<Object>(authenticationServiceRepositoryObj.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<Object> NewUser(AuthenticationServiceModel asmobj) {
        AuthenticationServiceDto asdobj = new AuthenticationServiceDto();
        System.out.println("Body data:    " + asmobj.toString());
        asdobj.setPassword(asmobj.getPassword());
        asdobj.setUserName(asmobj.getUserName());
        asdobj.setUserRole(asmobj.getUserRole());
        asdobj.setEmail(asmobj.getEmail());

        return new ResponseEntity<Object>(authenticationServiceRepositoryObj.save(asdobj), HttpStatus.CREATED);

    }
    
    public AuthenticationServiceDto addUser(AuthenticationServiceDto asmobj) {
        AuthenticationServiceDto asdobj = new AuthenticationServiceDto();
//        System.out.println("Body data:    " + asmobj.toString());
//        asdobj.setPassword(asmobj.getPassword());
//        asdobj.setUserName(asmobj.getUserName());
//        asdobj.setUserRole(asmobj.getUserRole());
//        asdobj.setEmail(asmobj.getEmail());
      

        return authenticationServiceRepositoryObj.save(asdobj);

    }

    public ResponseEntity<Object> findByUser(int id) throws UserNotFoundException {
        if (authenticationServiceRepositoryObj.existsById(id))
            return new ResponseEntity<Object>(authenticationServiceRepositoryObj.findById(id), HttpStatus.FOUND);
        else {
            throw new UserNotFoundException("Cannot find any user by the given id : " + id);
        }
    }


    public ResponseEntity<Object> UpdatingUser(AuthenticationServiceDto asdobj, int userId) throws UserNotFoundException {
        System.out.println("SERVICE :::" + userId + asdobj.toString().toString());
        if (authenticationServiceRepositoryObj.existsById(userId)) {
            AuthenticationServiceDto adb = new AuthenticationServiceDto();
            adb.setUserId(asdobj.getUserId());
            adb.setPassword(asdobj.getPassword());
            adb.setUserName(asdobj.getUserName());
            adb.setUserRole(asdobj.getUserRole());
            adb.setEmail(asdobj.getEmail());
            return new ResponseEntity<Object>(authenticationServiceRepositoryObj.save(adb), HttpStatus.ACCEPTED);
        } else {
            throw new UserNotFoundException("Cannot update any user by the given id : " + userId);

        }

    }

}

