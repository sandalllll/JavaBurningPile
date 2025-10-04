import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    //javac -d ./out ./src/*.java

    //jar cfm ./bin/app.jar ./src/manifest.mf -C ./out .
    //"C:\Program Files\Java\jdk-24\bin\jar.exe" cfm ./bin/app.jar ./src/manifest.mf -C ./out .

    //java -jar ./bin/app.jar
    public static void main(String[] args)
    {
        //N1
        {
            System.out.println("N1");
            System.out.print("input array size: ");
            Scanner s = new Scanner(System.in);
            int arrSize = Integer.parseInt(s.nextLine());
            Integer[] arr = new Integer[arrSize];
            Random randomGenerator = new Random();
            System.out.print("created: [");
            for (int i = 0; i < arrSize - 1; i++)
            {
                arr[i] = randomGenerator.nextInt(100);
                System.out.print(arr[i] + ", ");
            }
            arr[arrSize - 1] = randomGenerator.nextInt(100);
            System.out.println(arr[arrSize - 1] + "]");
            List<Integer> list = Arrays.asList(arr);
            System.out.println("created: List<Integer>");
            Collections.sort(list);
            System.out.print("sorted: ");
            System.out.println(list);
            Collections.shuffle(list);
            System.out.print("shuffled: ");
            System.out.println(list);
            {
                Integer a = list.getFirst();
                for (int i = 0; i < arrSize - 1; i++)
                {
                    list.set(i, list.get(i + 1));
                }
                list.set(arrSize - 1, a);
            }
            System.out.print("offseted: ");
            System.out.println(list);
            //map here
            {
                ArrayList<Integer> arL = new ArrayList<>(list);
                List<Integer> uniqueOnly = list.stream().distinct().collect(Collectors.toList());
                for (Integer a : uniqueOnly)
                {
                    int frq = Collections.frequency(arL, a);
                    System.out.println(a + " appears " + frq + " times");
                    if (frq == 1)
                        arL.removeAll(Collections.singletonList(a));
                }
                System.out.print("unique only: ");
                System.out.println(uniqueOnly);
                System.out.print("not unique only: ");
                System.out.println(arL);
                arrSize = arL.size();
                arr = new Integer[arrSize];
                for (int i = 0; i < arrSize; i++)
                {
                    arr[i] = arL.get(i);
                }
                System.out.println("transformed in to array");
                System.out.print("arr: [");
                for (int i = 0; i < arrSize - 1; i++)
                {
                    System.out.print(arr[i] + ", ");
                }
                if (arrSize > 0)
                    System.out.print(arr[arrSize - 1]);
                System.out.println("]");
            }
        }

        //N2
        {
            System.out.println("\nN2");
            System.out.print("input primes count: ");
            Scanner s = new Scanner(System.in);
            int arrSize = Integer.parseInt(s.nextLine());
            PrimeGenerator a = new PrimeGenerator(arrSize);
            PrimesGeneratorTest b = new PrimesGeneratorTest();
            b.Check(a.primes);
        }

        //N3
        {
            System.out.println("\nN3");
            ArrayList<Human> humans = new ArrayList<Human>(15);
            for (int i = 0; i < 15; i++)
            {
                humans.add(new Human());
            }
            {
                HashSet<Human> hs = new HashSet<>(humans);
                System.out.println(hs);
            }
            {
                LinkedHashSet<Human> lhs = new LinkedHashSet<>(humans);
                System.out.println(lhs);
            }
            {
                TreeSet<Human> ts = new TreeSet<>(new HumanLastNameComp());
                ts.addAll(humans);
                System.out.println(ts);
            }
            {
                TreeSet<Human> ts = new TreeSet<>(new HumanAgeComp());
                ts.addAll(humans);
                System.out.println(ts);
            }
            //разность - результат логики хранения данных в treeSet при которой экземпляры ме могут повтоятся
            //однако и в первом и во втором случае разные принципы, по которым определяется тождественность тех или иных экземпляров
        }

        //4
        {
            String txt;
            {
                System.out.println("\nN2");
                System.out.println("write something: ");
                Scanner s = new Scanner(System.in);
                txt = s.nextLine();
            }
            txt = txt.toLowerCase();
            txt = txt.replaceAll("[!\"#$%&`~()*+,./:;<=>?@^{}|\\[\\]\\\\]"," ");
            ArrayList<String> words = new ArrayList<String>(Arrays.stream(txt.split(" ")).toList());

            {
                Iterator<String> wrdi = words.iterator();
                while (wrdi.hasNext())
                {
                    String word = wrdi.next();
                    if (word.isEmpty())
                        wrdi.remove();
                }
            }

            HashMap<String, Integer> textStats = new HashMap<String, Integer>();

            {
                Iterator<String> wrdi = words.iterator();
                while (wrdi.hasNext())
                {
                    String word = wrdi.next();
                    if(textStats.containsKey(word))
                    {
                        Integer tmp = textStats.get(word);
                        tmp++;
                        textStats.replace(word, tmp);
                    }
                    else
                        textStats.put(word, 1);
                }
            }

            for (Map.Entry<String, Integer> entry : textStats.entrySet())
            {
                System.out.println(entry.getKey() + " contains " + entry.getValue() + " times");
            }
        }

        //5
        {
            System.out.println("\nN2");

            Map<Integer, Integer> map = new HashMap<>();

            {
                Scanner s = new Scanner(System.in);
                while (true)
                {
                    System.out.print("write key value (or 'x' to break): ");
                    String line = s.nextLine();
                    if (line.charAt(0) == 'x')
                        break;
                    Integer key = Integer.parseInt(line);
                    System.out.print("write value: ");
                    map.put(key, Integer.parseInt(s.nextLine()));
                }
            }

            Map<Integer, ArrayList<Integer>> inverseMap = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (inverseMap.containsKey(value))
                {
                    ArrayList<Integer> keysInv = inverseMap.get(value);
                    keysInv.add(key);
                }
                else
                {
                    ArrayList<Integer> keysInv = new ArrayList<>();
                    keysInv.add(key);
                    inverseMap.put(value, keysInv);
                }
            }
            System.out.println(inverseMap);
        }
    }
}