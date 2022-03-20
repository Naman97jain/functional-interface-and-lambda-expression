package com.fi.lambda.exp;

import java.util.function.BiConsumer;

public class FunctionalInterfacePractice {
	public static void main(String[] args) {
		int[] someNumbers = {1,2,3,4,5,6};
		int key = 2;
		process(someNumbers, key, wrappedLambda((v,k) -> System.out.println(v/k)));
		testRunnable(() -> System.out.println("Inside runnable method"));
	}
	
	private static void process(int[] someNumbers, int key,  BiConsumer<Integer, Integer> consumer) {
		for(int num: someNumbers) {
			consumer.accept(num, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrappedLambda(BiConsumer <Integer, Integer> consumer){
		return (v,k) -> {
			System.out.println("wrappedLambda called");
			consumer.accept(v, k);
		};
	}
	
	private static void testRunnable(Runnable r) {
		r.run();
	}
	
}
