package com.davidof.reactiverx.sotck;

import java.awt.image.CropImageFilter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import io.reactivex.Observable;

public class StockQuotes {
	
	public static Observable<StockQuote>  getStockQuotes() {
		Observable<StockQuote> stockQuotes = Observable.create(subscriber-> {
			LocalDateTime lastDate = LocalDateTime.now();
			double lastPrice = 25;
			int contador=0;
			while (!subscriber.isDisposed()) {
				lastDate = lastDate.plus(10, ChronoUnit.MINUTES);
				int signal = new Random().nextInt(1);
				Double incrementDecrement = new Double(new Random().nextInt(10)*0.1);
				lastPrice = signal==0?lastPrice - incrementDecrement:lastPrice+incrementDecrement;
				System.out.println("Valor emitido " + contador);
				contador++;
				subscriber.onNext(new StockQuote(lastPrice, lastDate, new Random().nextInt(1000)));
				
			}
		}) ;
		return stockQuotes;
	}

}
