/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Varnika Mujumdar
 */
public class Product {
    
    private String name;
    private int price;
    private int id;
    private ArrayList<Feature> features;
    private static int count = 0;
    
    public Product() {
        count++;
        id = count;
        features = new ArrayList<Feature>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public ArrayList<Feature> getFeatures()
    {
        return features;
    }
    
    public Feature addNewFeatures()
    {
        Feature newFeature = new Feature(this, "New Feature", "Default Value");
        features.add(newFeature);
        return newFeature;
    }

    
    @Override
    public String toString() {
        return name;
    }
    
}
