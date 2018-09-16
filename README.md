"# Roosevelt-POS" 

This is a POS system designed to run on a Raspberry Pi for a movie theater. It is based off of the current POS system used by the cinema. It is written in Java and uses the Swing library for the GUI. The database was created using SQLite.

To run it, simply download the jar file from the releases page and run. 

Clicking item buttons adds them to the order, which is reflected in the order window on the right. Clicking on the order window removes the last item added from the order. 

As items are added and removed from the order, the sales tax and subtotal of the order are updated. 

To complete an order, click on Exact Change, one of the existing monetary denomination buttons, or Start Tender.

Start Tender allows the user to enter any valid amount of cash that may have been tendered.

The monetary denomination and Start Tender buttons will also display the amount of change that is due.

Once an order has been completed, clicking the order window clears it out.
