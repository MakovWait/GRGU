package Classes.AssemblyLine;

import Interfaces.IAssemblyLine;
import Interfaces.ILineStep;
import Interfaces.IProduct;

public class AssemblyLine implements IAssemblyLine {

    ILineStep[] steps;

    public AssemblyLine(ILineStep[] steps){
        System.out.println("Creating assembly Line");
        this.steps = steps;
    }

    @Override
    public IProduct assembleProduct(IProduct product) {
        product.installFirstProductPart(steps[0].buildProductPart());
        product.installSecondProductPart(steps[1].buildProductPart());
        product.installThirdProductPart(steps[2].buildProductPart());

        return product;
    }
}
