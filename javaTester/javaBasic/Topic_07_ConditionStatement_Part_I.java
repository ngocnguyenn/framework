package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_ConditionStatement_Part_I {
	Scanner scanner = new Scanner(System.in);
	//@Test
	public void TC_01()
	{	
		System.out.println("Nhập số: ");
		int number = scanner.nextInt();
		
		if (number % 2 == 0)
		{
			System.out.println("Số " + number + " là số chẵn");
		} else System.out.println("Số " + number + " là số lẻ");
		
	}
	
	//@Test
	public void TC_02()
	{	
		System.out.println("Nhập số A: ");
		int numberA = scanner.nextInt();
		
		System.out.println("Nhập số B: ");
		int numberB = scanner.nextInt();
		
		if (numberA > numberB)
		{
			System.out.println("Số " + numberA + " lớn hơn số " + numberB);
		} else if (numberA == numberB) 
			{
			System.out.println(numberA + " bằng " + numberB);
			}
		else System.out.println(numberA + " nhỏ hơn " + numberB);
		
	}
	
	//@Test
	public void TC_03()
	{	
		System.out.println("Nhập tên người A: ");
		String nameA = scanner.nextLine();
		
		System.out.println("Nhập tên người B: ");
		String nameB = scanner.nextLine();
		
		if (nameA.equals(nameB)== true)
		{
			System.out.println("2 người này cùng tên");
		} else System.out.println("2 người này khác tên");
		
	}
	
	//@Test
	public void TC_04()
	{	
		System.out.println("Nhập số thứ nhất: ");
		int number1 = scanner.nextInt();
		
		System.out.println("Nhập số thứ hai: ");
		int number2 = scanner.nextInt();
		
		System.out.println("Nhập số thứ ba: ");
		int number3 = scanner.nextInt();
		
		if (number1 > number2 && number1 > number3)
		{
			System.out.println(number1 + " là số lớn nhất");
		} else if(number1 < number2 && number2 > number3)
		{
			System.out.println(number2 + " là số lớn nhất");
		} else if(number1 < number3 && number2 < number3)
		{
			System.out.println(number3 + " là số lớn nhất");
		}
	}
	
	//@Test
	public void TC_05()
	{	
		System.out.println("Nhập số a: ");
		int numberA = scanner.nextInt();
		
		if (numberA > 10 && numberA < 100)
		{
			System.out.println(numberA + " nằm trong khoảng [10,100]");
		} else System.out.println(numberA + " không nằm trong khoảng [10,100]");
	}

	//@Test
	public void TC_06()
	{
		System.out.println("Nhập điểm: ");
		float diem = scanner.nextFloat();
		
		if (diem >= 0 && diem < 5)
		{
			System.out.println("Điểm hệ số là D");
		} else if(5 <= diem && diem < 7.5)
		{
			System.out.println("Điểm hệ số là C");
		} else if(7.5 <= diem && diem < 8.5)
		{
			System.out.println("Điểm hệ số là B");
		}
		else if(8.5 <= diem && diem <= 10)
		{
			System.out.println("Điểm hệ số là A");
		} else System.out.println("Vui lòng nhập số điểm thích hợp");
	}
	
	@Test
	public void TC_07()
	{
		System.out.println("Nhập tháng: ");
		int month = scanner.nextInt();
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			System.out.println("Tháng " + month + " có 31 ngày");
		} else if(month == 4 || month == 6 || month == 9 || month == 11)
		{
			System.out.println("Tháng " + month + " có 30 ngày");
		} else if(month == 2)
		{
			System.out.println("Tháng " + month + " có 28 hoặc 29 ngày");
		}
		else System.out.println("Vui lòng nhập số tháng thích hợp.");
	}

}
