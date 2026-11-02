package Researcher;

import Equipment.Equipment;
import Equipment.EquipmentBag;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Researcher {

    private EquipmentBag equipmentBag;
    private int id;

    public Researcher(int id) {
        this.id = id;
        this.equipmentBag = new EquipmentBag();
    }

    public void takeEquipment(Equipment equipment) {
        equipmentBag.addEquipment(equipment);
    }
    
}
