package Classes;

import Classes.AssemblyLine.AssemblyLine;
import Classes.AssemblyLine.FirstLineStep;
import Classes.AssemblyLine.SecondLineStep;
import Classes.AssemblyLine.ThirdLineStep;
import Classes.Product.BallPen;
import Interfaces.ILineStep;
import Interfaces.IProduct;

public class Main {
    public static void main(String[] args) {
        AssemblyLine assemblyLine = new AssemblyLine(new ILineStep[]{new FirstLineStep(), new SecondLineStep(),
                                                        new ThirdLineStep()});
        IProduct assembledBallPen;

        assembledBallPen = assemblyLine.assembleProduct(new BallPen());
    }
}
