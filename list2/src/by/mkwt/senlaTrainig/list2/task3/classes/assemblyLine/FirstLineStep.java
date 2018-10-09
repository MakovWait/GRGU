package Classes.AssemblyLine;

import Classes.Product.BodyPart;
import Interfaces.ILineStep;
import Interfaces.IProductPart;

public class FirstLineStep implements ILineStep {

    public FirstLineStep(){
        System.out.println("Creating first line step");
    }

    @Override
    public IProductPart buildProductPart() {
        return new BodyPart();
    }
}
