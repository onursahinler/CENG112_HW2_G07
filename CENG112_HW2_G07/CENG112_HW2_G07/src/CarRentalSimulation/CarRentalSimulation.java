package CarRentalSimulation;
import java.util.Scanner;

public class CarRentalSimulation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many cars do you want to have(N): ");
        int N = scanner.nextInt();
        System.out.print("How many customers do you want to have(k): ");
        int k = scanner.nextInt();
        scanner.close();
        
        ArrayQueue<Car> carQueue = new ArrayQueue<>();

        for (int i = 0; i < N; i++) {
            Car car = new Car();
            car.setId("Car" + (i + 1));
            car.setQualityScore(Math.random() * 3 + 1); // 1 ile 3 arasında rastgele bir kalite puanı
            car.setOccupancy(0); // Başlangıçta işgal süresi 0 (kiralı değil)
            carQueue.enqueue(car);
        }
        
        ArrayQueue<Customer> customerQueue = new ArrayQueue<>();

        for (int i = 0; i < k; i++) {
            Customer customer = new Customer();
            customer.setId("Customer" + (i + 1));
            customer.setQualityThreshold(Math.random() * 3 + 1); // 1 ile 3 arasında rastgele bir kalite eşiği
            customerQueue.enqueue(customer);
        }
        while (!carQueue.isEmpty() && !customerQueue.isEmpty()) {
            Car car = carQueue.dequeue();
            Customer customer = customerQueue.dequeue();

            if (car.getQualityScore() > customer.getQualityThreshold()) {
                int occupancy = (int) (Math.random() * 5) + 1; // 1 ile 5 arasında rastgele bir işgal süresi
                car.setOccupancy(occupancy);
                System.out.println(customer.getId() + " accepted " + car.getId());

                // Müşteriyi silme işlemi
                //customerQueue.remove(customer);
            } else {
                customer.setQualityThreshold(customer.getQualityThreshold() * 0.9); // Müşterinin kalite eşiğini güncelleme
                System.out.println(customer.getId() + " rejected " + car.getId());

                // Müşteriyi bekleme listesine geri ekleme işlemi
                // customerQueue.add(customer);
            }

            // Tüm müşterilerin aracı reddettiği durumu kontrol etme
            if (customerQueue.isEmpty()) {
                carQueue.enqueue(car); // Aracı kuyruğun sonuna ekleme
            }
        }
     // Günlük istatistikleri tutmak için değişkenler
        int newlyRentedCars = 0;
        ArrayList<Car> availableCars = new ArrayList<>();
        // Her bir gün için döngü
        while (!carQueue.isEmpty() && !customerQueue.isEmpty()) {
            // Aracın işgal süresini azaltma
            for (int i = 0; i < availableCars.size(); i++) {
            	Car car = availableCars.get(i);
                int occupancy = car.getOccupancy();
                if (occupancy > 0) {
                    car.setOccupancy(occupancy - 1);
                }
            }

            // İşgal süresi 0 olan araçları kuyruğun başına ekleme
            while (!availableCars.isEmpty() && availableCars.get(0).getOccupancy() == 0) {
                carQueue.enqueue(availableCars.remove(0));
            }

            // Günlük istatistikleri yazdırma
            System.out.println("Available cars: ");
            for (int i = 0; i < availableCars.size(); i++) {
            	Car car = availableCars.get(i);
                System.out.println(car.getId());
            }
            System.out.println("Newly rented cars: " + newlyRentedCars);

            // Yeni kiralanan araç sayısını sıfırlama
            newlyRentedCars = 0;
        }
        
     // Tüm müşterilerin araç kiraladığı bir döngü
        while (!customerQueue.isEmpty() && !carQueue.isEmpty()) {
            Customer customer = customerQueue.dequeue();
            Car car = carQueue.dequeue();

            if (car.getQualityScore() > customer.getQualityThreshold()) {
                int rentalPeriod = (int) (Math.random() * 5) + 1;
                car.setOccupancy(rentalPeriod);
                newlyRentedCars++;
            } else {
                customer.setQualityThreshold(customer.getQualityThreshold() * 0.9);
                customerQueue.enqueue(customer);
            }
        }

	}
}
