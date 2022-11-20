package Controller;

import Model.CarryoutOrderList;
import View.CarryoutOrderView;

public class CarryoutOrderController {
    private CarryoutOrderList carryoutOrderModel;
    private CarryoutOrderView carryoutOrderView;

    CarryoutOrderController(){
        this.carryoutOrderModel = new CarryoutOrderList();
        this.carryoutOrderView = new CarryoutOrderView();
        System.out.println("The Carryout Food Order Controller was successfully initiated!");
        carryoutOrderView.displayCarryoutOrderTest(carryoutOrderModel.loadData());
    }

}
