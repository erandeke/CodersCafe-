package com.kedar.imc.test.admin;

import com.kedar.imc.models.Admin;
import com.kedar.imc.test.data.Fixtures;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminTest {

    Admin admin;

    @Before
    public void setUp() {
        this.admin = new Admin();
    }

    @Test
    public void shouldTestForValidMove() {
        //given
         admin.showAllowableMoves();

        //when
        boolean isActualMoveValid = admin.isTheMoveValid(Fixtures.getPaper());

        //then
        boolean isExpectedMoveValid = true;
        Assert.assertEquals(isExpectedMoveValid, isActualMoveValid);
    }


    @Test
    public void shouldTestForInvalidMove() {
        //given
        admin.showAllowableMoves();

        //when
        boolean isActualMoveValid = admin.isTheMoveValid(Fixtures.generateInvalidMove());

        //then
        boolean isExpectedMoveValid = false;
        Assert.assertEquals(isExpectedMoveValid, isActualMoveValid);
    }

}
