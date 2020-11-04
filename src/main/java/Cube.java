import java.util.*;

public class Cube {

    public static void main(String[] args){
        Project project1 = new Project("project1");
//        Package pkg = new Package("myPackage");
//        project1.addPakages(pkg);
//        pkg.addDependency(new Package("myPackage1"));
//        pkg.addDependency(new Package("myPackage2"));
//        pkg.addDependency(new Package("myPackage3"));
//
//        pkg.getDependencies().get(0).addDependency(new Package("myPackage11"));
//        pkg.getDependencies().get(0).addDependency(new Package("myPackage12"));
//        pkg.getDependencies().get(0).addDependency(new Package("myPackage13"));

        //pkg.getDependencies().get(0).getDependencies().get(2).addDependency(pkg);


        Package pkgA = new Package("A");
        project1.addPakages(pkgA);
        pkgA.addDependency(new Package("B"));
        pkgA.addDependency(new Package("X"));
        pkgA.getDependencies().get(0).addDependency(new Package("C"));
        pkgA.getDependencies().get(0).addDependency(new Package("T"));

        Package pkgD = new Package("D");
        pkgD.addDependency(pkgA.getDependencies().get(0).getDependencies().get(0));
        Package pkgE = new Package("E");
        pkgE.addDependency(new Package("Y"));
        pkgD.addDependency(pkgE);
        Package pkgC = pkgA.getDependencies().get(0).getDependencies().get(0);
        pkgC.addDependency(new Package("R"));
        Package pkgF = new Package("F");
        pkgF.addDependency(pkgE);
        pkgF.addDependency(new Package("U"));

        List<Package> listP = new ArrayList<>();
        //listP.add(pkg);
        listP.add(pkgA);
        listP.add(pkgD);
        listP.add(pkgF);
        if(project1.hasCyclicDependencies(listP) == true)
            throw new RuntimeException("есть цикл");

        List<Package> ordered = project1.getCompilationOrder(listP);

        ordered.stream().forEach(i-> System.out.println(i.getName()));


    }


}




