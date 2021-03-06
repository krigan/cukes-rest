package lv.ctco.cukesrest.common;

import com.google.inject.*;
import lv.ctco.cukesrest.gadgets.dto.*;

import java.util.*;

import static lv.ctco.cukesrest.gadgets.dto.GadgetType.*;

@Singleton
public class InMemoryStorage {

    private Map<Integer, GadgetDto> gadgets = new HashMap<Integer, GadgetDto>();

    @Inject
    public void init() throws Exception {
        initGadget(1857, SMARTPHONE, "LG Nexus 5", "Lisa", 8);
        initGadget(1858, LAPTOP, "Macbook Air", "Homer", 38);
        initGadget(1859, LAPTOP, "Alienware 17 R3", "Bart", 10);
        initGadget(1860, SMART_WATCH, "Apple Watch", "Marge", 36);
        initGadget(1861, TABLET, "Samsung Galaxy Tab 2", "Maggie", 2);
    }

    public Map<Integer, GadgetDto> getGadgets() {
        return gadgets;
    }

    private void initGadget(Integer id, GadgetType type, String gadgetName, String name, Integer age) {
        GadgetDto gadget = new GadgetDto();

        gadget.setId(id);
        gadget.setType(type);
        gadget.setName(gadgetName);
        gadget.setOwner(new Owner(name, "Simpson", age));
        gadget.setCreatedDate(new Date());

        gadgets.put(id, gadget);
    }
}
