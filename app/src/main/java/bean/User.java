package bean;

import RecycleViewutil.entity.MultiItemEntity;

/**
 * Created by Umbrella on 2019/2/26.
 */

public class User implements MultiItemEntity{
    private String name;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return 2;
    }

    public User(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
