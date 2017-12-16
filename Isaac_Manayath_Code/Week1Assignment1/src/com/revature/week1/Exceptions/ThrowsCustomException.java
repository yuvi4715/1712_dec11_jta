package com.revature.week1.Exceptions;

public class ThrowsCustomException {
	

    public static void findByName(String name) throws CustomException {

        if ("".equals(name)) {
            throw new CustomException();
        }

    }

    public static void main(String[] args) {


        try {

           findByName("");

        } catch (CustomException e) {
            e.printStackTrace();
        }

    }

}
