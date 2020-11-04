import java.util.*;
import java.util.stream.Collectors;

//        2а) В списке packages не может быть дубликатов, поэтому решение всегда выдает false. Нужен рекурсивный алгоритм обхода графа.
//        2б) TreeSet элементы сортирует по алфавиту(по-умолчанию). Здесь также нужен рекурсивный алгоритм.

public class Project {
    //имя проекта
    private final String name;
    //список пакетов проекта
    private final List<Package> packages = new ArrayList<>();

    List<Package> allPackages = new ArrayList<>();
    List<Package> orderedList = new LinkedList<>();
    Boolean circle;

    public Project(String name) {
        this.name = name;
    }

    public void addPakages(Package packag) {
        this.packages.add(packag);
    }

    public Boolean hasCyclicDependencies(List<Package> packages) {
        for (Package packag : packages) {
            circle = false;
            allPackages.clear();
            allPackages.add(packag);
            check(packag);
            return circle;
        }
        return false;
    }

    private void check(Package packag1) {
        for(Package packag:packag1.getDependencies()) {
            if (allPackages.contains(packag)) {
                circle = true;
                return;
            }
            allPackages.add(packag);
            if (!packag.getDependencies().isEmpty())
                check(packag);
        }
    }

    protected List<Package> getCompilationOrder(List<Package> packages) {
        List<Package> packagesRes = new LinkedList<>();
        List<List<Package>> list = new LinkedList<>();
        for (Package packag : packages) {
            list.clear();
            orderedList.clear();
            orderedList.add(packag);
            list.add(sequence(packag));
            for (List<Package> lists:list) {
                if(packagesRes.isEmpty()){
                    packagesRes.addAll(lists);
                }else {
                    for (Package pak : lists) {
                        if(packagesRes.contains(pak)){
                            for (int i =0;i<lists.indexOf(pak);i++)
                                packagesRes.add(packagesRes.indexOf(pak) + i, lists.get(i));
                            lists = lists.subList(lists.indexOf(pak),lists.size());
                        }
                        packagesRes.add(pak);
                    }
                }
            }
        }
        return packagesRes.stream().distinct().collect(Collectors.toCollection(() -> new LinkedList<>()));
    }

    private List<Package> sequence(Package packag1) {
        for(Package packag:packag1.getDependencies()) {
            orderedList.add(packag);
            if (!packag.getDependencies().isEmpty())
                sequence(packag);
        }
        return orderedList;
    }

}