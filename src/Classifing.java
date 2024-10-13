import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Classifing {
    private boolean isHumanoid;
    private String planet;
    private Integer ageMin;
    private Integer ageMax;
    private List<String> traits;

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public void setHumanoid(boolean humanoid) {
        isHumanoid = humanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public static Map<String, List<Classifing>> getAllSpecies() {
        Map<String, List<Classifing>> speciesMap = new HashMap<>();

        List<Classifing> starWarsSpecies = new ArrayList<>();
        starWarsSpecies.add(new Classifing() {{
            setHumanoid(false);
            setPlanet("Kashyyyk");
            setAgeMin(0);
            setAgeMax(400);
            setTraits(new ArrayList<>() {{
                add("HAIRY");
                add("TALL");
            }});
        }});
        starWarsSpecies.add(new Classifing() {{
            setHumanoid(false);
            setPlanet("Endor");
            setAgeMin(0);
            setAgeMax(60);
            setTraits(new ArrayList<>() {{
                add("SHORT");
                add("HAIRY");
            }});
        }});
        speciesMap.put("Star Wars", starWarsSpecies);

        List<Classifing> marvelSpecies = new ArrayList<>();
        marvelSpecies.add(new Classifing() {{
            setHumanoid(true);
            setPlanet("Asgard");
            setAgeMin(0);
            setAgeMax(5000);
            setTraits(new ArrayList<>() {{
                add("BLONDE");
                add("TALL");
            }});
        }});
        speciesMap.put("Marvel", marvelSpecies);

        List<Classifing> hitchhikerSpecies = new ArrayList<>();
        hitchhikerSpecies.add(new Classifing() {{
            setHumanoid(true);
            setPlanet("Betelgeuse");
            setAgeMin(0);
            setAgeMax(100);
            setTraits(new ArrayList<>() {{
                add("EXTRA_ARMS");
                add("EXTRA_HEAD");
            }});
        }});
        hitchhikerSpecies.add(new Classifing() {{
            setHumanoid(false);
            setPlanet("Vogsphere");
            setAgeMin(0);
            setAgeMax(200);
            setTraits(new ArrayList<>() {{
                add("GREEN");
                add("BULKY");
            }});
        }});
        speciesMap.put("Hitchhiker", hitchhikerSpecies);

        List<Classifing> lordOfTheRingsSpecies = new ArrayList<>();
        lordOfTheRingsSpecies.add(new Classifing() {{
            setHumanoid(true);
            setPlanet("Earth");
            setAgeMin(null);
            setAgeMax(null);
            setTraits(new ArrayList<>() {{
                add("BLONDE");
                add("POINTY_EARS");
            }});
        }});
        lordOfTheRingsSpecies.add(new Classifing() {{
            setHumanoid(true);
            setPlanet("Earth");
            setAgeMin(0);
            setAgeMax(200);
            setTraits(new ArrayList<>() {{
                add("SHORT");
                add("BULKY");
            }});
        }});
        speciesMap.put("LOTR", lordOfTheRingsSpecies);

        return speciesMap;
    }
}
