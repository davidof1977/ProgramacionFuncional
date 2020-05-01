package com.davidof.reactiverx;

public class TestCustomerObservable {

	public static void main(String[] args) {
		
		CustomerObservable miObservable = new CustomerObservable("David");
		miObservable.subscribe(mensajeRecibido ->{
				mensajeRecibido.forEach(c->{
					String s = "Lista 1 " + c.toString();
					System.out.println(s);
				});
		});
		miObservable.recuperarOrdenesCompra();
		
		CustomerObservable miObservable2 = new CustomerObservable("Mario");
		miObservable2.subscribe(mensajeRecibido ->{
			mensajeRecibido.forEach(c->{
				String s = "Lista 2 " + c.toString();
				System.out.println(s);
			});
	});
		miObservable2.recuperarOrdenesCompra();
		
		miObservable = new CustomerObservable("Daniel");
		miObservable.subscribe(mensajeRecibido ->{
			mensajeRecibido.forEach(c->{
				String s = "Lista 3 " + c.toString();
				System.out.println(s);
			});
	});
		miObservable.recuperarOrdenesCompra();
	
		miObservable = new CustomerObservable("Javi");
		miObservable.subscribe(mensajeRecibido ->{
			mensajeRecibido.forEach(c->{
				String s = "Lista 4 " + c.toString();
				System.out.println(s);
			});
	});
		miObservable.recuperarOrdenesCompra();
		
		
		
		otrosProcesos();
		
		
	}

	private static void otrosProcesos() {
		System.out.println("Imprimir n ");
		long n=0;
		for(long i=0;i<100000000;i++) {
			n=+i;
			if(n % 1000000 ==0)
				System.out.println("multiplo de 1000000 " + n);
		}
		System.out.println("Impresos " + n);
	}
	
	

}
