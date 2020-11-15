package advanced_structures;

public class AdjacentDestinationVertex {
	private String name;
	private int weight;
	
	public AdjacentDestinationVertex(String name) {
		super();
		this.name = name;
	}
	public AdjacentDestinationVertex(String name, int weight) {
		this(name);
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdjacentDestinationVertex other = (AdjacentDestinationVertex) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AdjacentDestinationVertex [" + name + ", " + weight + "]";
	}
	
}
