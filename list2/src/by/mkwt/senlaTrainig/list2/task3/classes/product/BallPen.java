package Classes.Product;

import Interfaces.IProduct;
import Interfaces.IProductPart;

public class BallPen implements IProduct {

    IProductPart firstProductPart;
    IProductPart secondProductPart;
    IProductPart thirdProductPart;

    public BallPen(){
        System.out.println("Creating empty pen");
    }

    @Override
    public void installFirstProductPart(IProductPart productPart) {
        System.out.println("Install first part..");
        firstProductPart = productPart;
    }

    @Override
    public void installSecondProductPart(IProductPart productPart) {
        System.out.println("Install second part..");
        secondProductPart = productPart;
    }

    @Override
    public void installThirdProductPart(IProductPart productPart) {
        System.out.println("Install third part..");
        thirdProductPart = productPart;
    }
}
