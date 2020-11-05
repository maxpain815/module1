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
            check(packag);
            return circle;
        }
        return false;
    }

    private void check(Package packag) {
        if (allPackages.contains(packag)) {
            circle = true;
            return;
        }
        allPackages.add(packag);
        for (Package packag1 : packag.getDependencies()) {
            if (!packag.getDependencies().isEmpty())
                check(packag1);
        }
        if(!orderedList.contains(allPackages.get(allPackages.size()-1)))
        orderedList.add(allPackages.get(allPackages.size()-1));

        allPackages.remove(allPackages.size()-1);
    }

    protected List<Package> getCompilationOrder(List<Package> packages) {
        List<Package> packagesRes = new LinkedList<>();
        orderedList.clear();
        allPackages.clear();
        for (Package packag : packages) {
            sequence(packag);
            List<Package> list = orderedList;
            if (packagesRes.isEmpty()) {
                packagesRes.addAll(list);
            } else {
                for (Package pak : list) {
                    if (packagesRes.contains(pak)) {
                        for (int i = 0; i < list.indexOf(pak); i++)
                            packagesRes.add(packagesRes.indexOf(pak) + i, list.get(i));
                        list = list.subList(list.indexOf(pak), list.size());
                    }
                    packagesRes.add(pak);
                }
            }
        }
        return packagesRes.stream().distinct().collect(Collectors.toCollection(() -> new LinkedList<>()));
    }

    private void sequence(Package packag1) {
        allPackages.add(packag1);
        if (!packag1.getDependencies().isEmpty()) {
            for (Package packag : packag1.getDependencies()) {
                sequence(packag);
            }
        }
        if(!orderedList.contains(allPackages.get(allPackages.size()-1)))
        orderedList.add(allPackages.get(allPackages.size()-1));
        allPackages.remove(allPackages.size()-1);
    }

}