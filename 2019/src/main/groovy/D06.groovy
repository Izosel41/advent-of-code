import java.util.stream.Collectors

class D06 {

    Planet createOrbit(String cmd) {
        def orb = cmd.tokenize(")")
        Planet a = new Planet(orb[0])
        Planet b = new Planet(orb[1])
        b.orbits(a)
        b
    }

    List<Planet> createOrbits(List<String> cmds) {
        List<Planet> planets = new ArrayList<>()

        for (String c : cmds) {
            Planet p = createOrbit(c)
            planets.add(p)
        }
        planets
    }

    int calculateOrbits(List<Planet> planets, Planet p) {
        int orbit = 0
        while (p != null && p.parent != null) {
            p = planets.find({ it == p.parent })
            orbit++
        }
        orbit
    }

    List<String> computePath(List<Planet> planets, Planet p) {
        List path = new ArrayList<String>()
        while (p != null && p.parent != null) {
            p = planets.find({ it == p.parent })
            if (p != null)
                path.add(p.name)
        }
        path
    }
}

public class Planet {
    String name
    Planet parent

    Planet(String name) {
        this.name = name
        this.parent = null
    }

    void orbits(Planet p) {
        this.parent = p
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Planet planet = (Planet) o

        if (name != planet.name) return false

        return true
    }

    int hashCode() {
        return (name != null ? name.hashCode() : 0)
    }

    @Override
    public String toString() {
        return name + '(' + parent
    }
}
