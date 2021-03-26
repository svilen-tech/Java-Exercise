import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

public class CustomLinkedListTest {

    CustomLinkedList<Integer> customList;
    @Before
    public void ctorBuild(){
     customList   = new CustomLinkedList();
    }

    @Test
    public void test_getWorkCorrectly(){
        customList.add(5);
        customList.add(8);
        Assert.assertEquals(5,(int)customList.get(0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_throwExceptionWhenGetNullIndex(){
        customList.add(5);
        customList.add(8);
        customList.get(12);
    }

    @Test
    public void test_properlyElementsSetting(){
       customList.add(15);
       customList.add(12);
       customList.add(69);
       customList.set(1,19);
       int ourValue=customList.get(1);
       Assert.assertEquals(ourValue,19);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_getExceptionWhenSetOnNotPossibleElement(){
        customList.add(15);
        customList.add(12);
        customList.add(69);
        customList.set(49,19);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_removeAtAndGetExceptionForNotPossibleElement(){
        customList.removeAt(6);
    }
    @Test
    public void test_removeAtSpecificElement(){
        customList.add(8);
        customList.add(10);
        Assert.assertEquals((int)customList.removeAt(0), 8);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_removeAtSpecificElementWithHigherIndex(){
        customList.add(8);
        customList.add(10);
        customList.removeAt(55);
    }
    @Test
    public void removeByElementAndGetProperIndex(){
        customList.add(13);
        customList.add(42);
        customList.add(69);
        Assert.assertEquals(customList.remove(42),1);
    }
    @Test
    public void removeByElementThatDoesntExists(){
        customList.add(13);
        Assert.assertEquals(customList.remove(44),-1);

    }
    @Test
    public void getProperIndexOfItem(){
        customList.add(13);
        customList.add(42);
        customList.add(69);
        Assert.assertEquals(customList.indexOf(42),1);
    }
    @Test
    public void testIfIndexForIndexOfItemIsInvalid(){
        customList.add(13);
        customList.add(42);
        Assert.assertEquals(customList.indexOf(656),-1);
    }
    @Test
    public void testContainsMethod(){
        customList.add(13);
        Assert.assertTrue(customList.contains(13));
    }
    @Test
    public void testWhenRemoveTheOnlyElement(){
        customList.add(13);
        Assert.assertEquals(customList.remove(13),0);
    }

}
