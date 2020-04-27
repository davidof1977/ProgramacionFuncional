package com.davidof.functional;

public class Order {

	public Integer OrderId;
	public Double importe;
	public Order(Integer orderId, Double importe) {
		super();
		OrderId = orderId;
		this.importe = importe;
	}
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", importe=" + importe + "]";
	}
}
