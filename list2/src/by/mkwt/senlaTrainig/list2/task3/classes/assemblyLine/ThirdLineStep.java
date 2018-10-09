package Classes.AssemblyLine;

import Classes.Product.KernelPart;
import Interfaces.ILineStep;
import Interfaces.IProductPart;

public class ThirdLineStep implements ILineStep {

    public ThirdLineStep(){
        System.out.println("Creating third line step");
    }

    @Override
    public IProductPart buildProductPart() {
        return new KernelPart();
    }
}
