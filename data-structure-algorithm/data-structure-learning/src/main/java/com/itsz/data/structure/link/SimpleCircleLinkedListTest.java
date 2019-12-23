package com.itsz.data.structure.link;

import org.junit.Test;

public class SimpleCircleLinkedListTest {

    @Test
    public void testList (){
        SimpleCircleLinkList circleLinkList = new SimpleCircleLinkList(8);

        circleLinkList.list();
    }

    @Test
    public void testJoseph(){
        SimpleCircleLinkList circleLinkList = new SimpleCircleLinkList(25);
        circleLinkList.joseph(3,4);
    }
}
