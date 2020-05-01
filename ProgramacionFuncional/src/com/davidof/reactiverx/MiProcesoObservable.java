package com.davidof.reactiverx;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class MiProcesoObservable extends Observable<String>{

	private List<Observer<? super String>> misObservadores = new LinkedList<>();
	private String mensaje;
	public MiProcesoObservable(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	@Override
	protected void subscribeActual(Observer<? super String> observer) {
		misObservadores.add(observer);
		
	}
	
	public void enviarMensaje() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				misObservadores.forEach(o->{
					try {
					 Thread.sleep(1500);
					 o.onNext(mensaje);
					}catch(InterruptedException ie) {
						ie.printStackTrace();
					}
				});
				misObservadores.forEach(o->{
					o.onComplete();
					System.out.println("Adios " + mensaje);
				});
			}
		}, 400);;
	}
}