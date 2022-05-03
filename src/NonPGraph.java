import java.util.HashMap;
import java.util.Map;

class Emp {
    int id;
    String name;
    float salary;
    Emp(int id,String name,float salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void Dis(Emp obj){
        System.out.print(obj.id + " " + obj.name+" "+obj.salary);
    }
}
public class NonPGraph {
    Map<Emp, linkedList<Emp>> mp;
    public NonPGraph(){
        mp = new HashMap<>();
    }
    public void addEdge(Emp o1,Emp o2,boolean isBidir){
        linkedList<Emp> o1Neighbor = mp.getOrDefault(o1,new linkedList<Emp>());
        o1Neighbor.add(o2);
        mp.put(o1,o1Neighbor);
        if(isBidir) addEdge(o2,o1,false);
    }
    public void ismap(){
        for(Map.Entry<Emp,linkedList<Emp>> res: mp.entrySet()) {
            System.out.println(res.getKey().id);
        }
    }
    public void display(){
        for(Map.Entry<Emp,linkedList<Emp>> res: mp.entrySet()){
            Emp ob = res.getKey();
            ob.Dis(ob);
            System.out.print(" ->");
           // System.out.print(temp1 + " ");
            linkedList<Emp> temp = res.getValue();
           Node<Emp> temp2 = temp.head;
           while (temp2!=null){
              // System.out.print(" "+temp2.data.id+" "+temp2.data.name +" "+temp2.data.salary);
              Emp obj = temp2.data;
              obj.Dis(obj);
               System.out.println();
               temp2 = temp2.next;
           }
        }
    }

    public static void main(String[] args) {
        NonPGraph obj = new NonPGraph();
        obj.addEdge(new Emp(100,"Prayas",35000f),new Emp(101,"Prayas1",35001f),true);
        obj.addEdge(new Emp(101,"Prayas1",35001f),new Emp(103,"Prayas4",35003f),true);
        obj.addEdge(new Emp(101,"Prayas1",35001f),new Emp(104,"Prayas6",35001f),true);
        obj.ismap();
    }
}
