import java.util.LinkedHashMap;
import java.util.List;

public class ShippingService {
    public void ship(List<Shippable> shippables) {
        double totalWeight = 0;
        System.out.println("** Shipment notice ** ");

        LinkedHashMap<String,Integer> count = new LinkedHashMap<>();
        LinkedHashMap<String,Double> weight = new LinkedHashMap<>();
        for (Shippable s: shippables) {
            count.put(s.getName(), count.getOrDefault(s.getName(),0) + 1);
            weight.put(s.getName(), s.getWeight());
            totalWeight += s.getWeight();
        }
        for (String i: count.keySet()) {
            System.out.printf("%dx %-12s %.0fg\n",count.get(i),i,weight.get(i)*count.get(i));
        }
        System.out.printf("Total package weight %.1fkg\n",totalWeight/1000);
    }

}
