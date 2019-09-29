 /*
 *	Day of the week
 *	Given three integers A, B and C, find and return the day of the week for the given date A/B/C where A represents the date, B represents the month and C represents the year. Assume that Jan 1st 1 AD is a Monday in Gregorian calendar. February has 28 days(excluding leap years when it has 29 days). Leap year is a year that is either (divisible by 400) or (divisible by 4 and not divisible by 100). 
 *	Input Format
 *	The 3 arguments given are the integers A, B and C.
 *	Output Format
 *	Return the day of the year as a string of lower case english alphabets.
 *	Answer will be one of the following {sunday, monday, tuesday, wednesday, thursday, friday, saturday}.
 *	Constraints
 *	1 <= A <= 31
 *	1 <= B <= 12
 *	1990 <= C <= 2100
 *	For Example
 *	Input 1:
 *	    A = 19
 *	    B = 4
 *	    C = 2019
 *	Output 1:
 *	    friday
 *	
 *	Input 2:
 *	    A = 7
 *	    B = 10
 *	    C = 1996
 *	Output 2:
 *	    monday
 *	
 */	

public class Solution {
    public String solve(int A, int B, int C) {
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
        
        int days = A + ((C - 1) * 365) + monthDays(B - 1, month) + leapYears(C, B);
        return day[days%7];
        
    }
    
    int monthDays(int m, int[] month){
        int totalDays = 0;
        for(int i = 1; i <= m; i++){
            totalDays += month[i];
        }
      
        return totalDays;
    }
    
    int leapYears(int y, int m){
        if(m <= 2){
            y--;
        }
        return y/4 + y/400 - y/100;
    }
     
}

