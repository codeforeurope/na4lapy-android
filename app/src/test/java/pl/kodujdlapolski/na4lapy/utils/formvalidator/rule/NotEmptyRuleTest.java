/*
 *	Copyright 2017 Stowarzyszenie Na4Łapy
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package pl.kodujdlapolski.na4lapy.utils.formvalidator.rule;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotEmptyRuleTest {

    @Mock
    private TextInputLayout textInputLayout;

    @Mock
    private TextInputEditText textInputEditText;

    @Mock
    private Editable editable;

    private NotEmptyRule notEmptyRule;

    @Before
    public void setUp() throws Exception {
        notEmptyRule = new NotEmptyRule(textInputEditText, textInputLayout, 0);
    }

    @Test
    public void testValidateSuccess() throws Exception {
        // given
        String text = "text";
        when(textInputEditText.getText()).thenReturn(editable);
        when(editable.toString()).thenReturn(text);

        // when
        boolean result = notEmptyRule.validate();

        // then
        assertTrue(result);
    }

    @Test
    public void testValidateFail() throws Exception {
        // given
        String text = "";
        when(textInputEditText.getText()).thenReturn(editable);
        when(editable.toString()).thenReturn(text);

        // when
        boolean result = notEmptyRule.validate();

        // then
        assertFalse(result);
    }
}