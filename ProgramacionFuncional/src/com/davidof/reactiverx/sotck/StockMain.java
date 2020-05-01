package com.davidof.reactiverx.sotck;

import io.reactivex.Observable;

public class StockMain {

	public static void main(String[] args) {
		Observable<StockQuote> stockQuotes = StockQuotes.getStockQuotes().take(2000).cache();
		
		stockQuotes.groupBy(sq -> sq.getDate().toLocalDate())
		   			.concatMap(group->group.reduce(0,(total,y)->total=total+y.getVolumen()).toObservable()
				   .map(volume -> new VolumeData(group.getKey(), volume)))
		   		.subscribe(volumeData -> System.out.println("Info " + volumeData.toString()));;

	}

}
