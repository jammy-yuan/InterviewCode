package com.gec.domain;

public class Robot {
	private Head head;
	private Body body;
	private Hand hand;
	private Foot foot;
	
	public Robot() {
		System.out.println("{debug} �����˻����˹Ǽ� ����");
	}
	
	public Head getHead() {
		return head;
	}
//	public void setHead(Head head) {
//		System.out.println("{debug} װ����:"+ head.getDescript() );
//		this.head = head;
//	}
	
	public void setHead2(Head head) {
		System.out.println("{debug} װ����:"+ head.getDescript() );
		this.head = head;
	}
	
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		System.out.println("{debug} װ����:"+ body.getDescript() );
		this.body = body;
	}
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		System.out.println("{debug} װ����:"+ hand.getDescript() );
		this.hand = hand;
	}
	public Foot getFoot() {
		return foot;
	}
	public void setFoot(Foot foot) {
		System.out.println("{debug} װ����:"+ foot.getDescript() );
		this.foot = foot;
	}
}
