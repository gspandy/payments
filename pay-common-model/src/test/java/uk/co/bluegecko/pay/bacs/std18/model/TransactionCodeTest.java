package uk.co.bluegecko.pay.bacs.std18.model;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import uk.co.bluegecko.pay.bacs.std18.model.TransactionCode.AuddisCode;
import uk.co.bluegecko.pay.bacs.std18.model.TransactionCode.CreditCode;
import uk.co.bluegecko.pay.bacs.std18.model.TransactionCode.DebitCode;


public class TransactionCodeTest
{

	@Test
	public final void testByCodePassCredit()
	{
		assertThat( TransactionCode.byCode( CreditCode.class, "Z4" ), is( CreditCode.INTEREST ) );
	}

	@Test
	public final void testByCodePassDebit()
	{
		assertThat( TransactionCode.byCode( DebitCode.class, "17" ), is( DebitCode.REGULAR ) );
	}

	@Test
	public final void testByCodePassAudis()
	{
		assertThat( TransactionCode.byCode( AuddisCode.class, "0N" ), is( AuddisCode.NEW ) );
	}

	@Test
	public final void testValueOfCredit()
	{
		assertThat( CreditCode.valueOf( "INTEREST" ), is( CreditCode.INTEREST ) );
	}

	@Test
	public final void testValueOfDebit()
	{
		assertThat( DebitCode.valueOf( "REGULAR" ), is( DebitCode.REGULAR ) );
	}

	@Test
	public final void testValueOfAudis()
	{
		assertThat( AuddisCode.valueOf( "NEW" ), is( AuddisCode.NEW ) );
	}

	@Test( expected = IllegalArgumentException.class )
	public final void testByCodeFail()
	{
		TransactionCode.byCode( CreditCode.class, "17" );
	}

	@Test
	public final void testAllByCodePass()
	{
		assertThat( TransactionCode.byCode( "Z4" ), is( CreditCode.INTEREST ) );
	}

	@Test( expected = IllegalArgumentException.class )
	public final void testAllByCodeFail()
	{
		TransactionCode.byCode( "XX" );
	}

}
