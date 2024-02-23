class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stockCount;

    public Product(int id, String name, String description, double price, int stockCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockCount = stockCount;
    }

    // Getters and setters for the Product class
    // ...

    public String display() {
        return "ID: " + id +
                "\nName: " + name +
                "\nDescription: " + description +
                "\nPrice: $" + price +
                "\nStock Count: " + stockCount + "\n";
    }

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setDescription(String description) {
        this.description = description;
    }
	
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
	
	public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

	
}

