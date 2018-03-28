package com.lw.test;

public class TestEnum {
	 
    public static void main(String[] args) {
 
        showColor( Color.RED );
 
    }
 
    static void showColor(Color color){
        switch ( color ) {
        case BLANK:
            System.out.println( color );
            break;
        case RED :
            System.out.println( color );
            break;
        default:
            System.out.println( color );
            break;
        }
         
    }
}

enum Color {
    
    RED, GREEN, BLANK, YELLOW 

}