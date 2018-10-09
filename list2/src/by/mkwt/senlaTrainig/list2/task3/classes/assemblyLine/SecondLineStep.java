package Classes.AssemblyLine;

import Classes.Product.SpringPart;
import Interfaces.ILineStep;
import Interfaces.IProductPart;

public class SecondLineStep implements ILineStep {

    public SecondLineStep(){
        System.out.println("Creating second line step");
    }
    @Override
    public IProductPart buildProductPart() {
        return new SpringPart();
    }
}
