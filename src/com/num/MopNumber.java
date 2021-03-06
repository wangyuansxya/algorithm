package com.num;

/**
 * 2开头，之后的数都是3，且为素数，称为猫扑素数
 */
public class MopNumber {

	/**
	 * 是否是猫扑数
	 * 2开头，2之后的数字都是3
	 * @param num
	 * @return
	 */
	public static boolean isMopNumber(int num) {
		if(num < 10) {
			return num == 2;
		} else {
			return num % 10 == 3 && isMopNumber(num / 10);
		}

	}


	/**
	 * 用于判断一个数是否为素数，若为素数，返回true,否则返回false
	 * 是否是素数
	 * 除了0，1和本身外，不能被其他自然数整除的数叫做质数
	 * @param num
	 */
	public static boolean isPrime(int num) {

		if(num < 2) {
			return false;
		} else {
			for(int i = 2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					return false;

				}
			}

		}
		return true;
	}

	public static void main(String[] args) {
		for(int i = 0; i < 1000000; i++) {
			if(isMopNumber(i)) {
				if(isPrime(i)) {
					System.out.println(i);
				}
			}
		}
		System.out.println(Math.sqrt(3));
	}

}

