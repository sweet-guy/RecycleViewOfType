package bean;

import RecycleViewutil.entity.MultiItemEntity;
import RecycleViewutil.entity.SectionEntity;

/**
 * Created by Umbrella on 2019/2/26.
 */

public class SectionMultipleItem extends SectionEntity<User> implements MultiItemEntity{
    public static final int TEXT = 1;
    public static final int IMG_TEXT = 2;
    private int itemType;
    private User user;
    public SectionMultipleItem(int itemType,User user) {
        super(user);
        this.user=user;
        this.itemType=itemType;
    }
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user=user;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
