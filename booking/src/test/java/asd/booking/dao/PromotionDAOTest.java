package asd.booking.dao;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PromotionDAOTest extends TestCase {

    public void testGetPercent() {
        Double result = PromotionDAO.getPercent("ABCDE");
        Assert.assertNotNull(result);
    }
}