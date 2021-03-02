package com.gec.domain;

public class Robot {
	private Head head;
	private Body body;
	private Hand hand;
	private Foot foot;
	
	public Robot() {
		System.out.println("{debug} 创建了机器人骨架 。。");
	}
	
	public Head getHead() {
		return head;
	}
//	public void setHead(Head head) {
//		System.out.println("{debug} 装配了:"+ head.getDescript() );
//		this.head = head;
//	}
	
	public void setHead2(Head head) {
		System.out.println("{debug} 装配了:"+ head.getDescript() );
		this.head = head;
	}
	
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		System.out.println("{debug} 装配了:"+ body.getDescript() );
		this.body = body;
	}
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		System.out.println("{debug} 装配了:"+ hand.getDescript() );
		this.hand = hand;
	}
	public Foot getFoot() {
		return foot;
	}
	public void setFoot(Foot foot) {
		System.out.println("{debug} 装配了:"+ foot.getDescript() );
		this.foot = foot;
	}
}
