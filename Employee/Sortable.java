package Employee;

abstract class Sortable {
	public abstract int compare(Sortable b);
	public static void shell_sort(Sortable[] a) {
		
		 // Mulailah dengan celah besar, lalu kurangi jaraknya
	    for (int gap = a.length/2; gap > 0; gap /= 2)
	    {
	        // Lakukan penyisipan celah untuk ukuran celah ini.
			// Elemen celah pertama a [0..gap-1] sudah dalam urutan gapped
			// tetap tambahkan satu elemen lagi hingga seluruh array menjadi
			// gap diurutkan
	        for (int i = gap; i < a.length; i += 1)
	        {
				// tambahkan [i] ke elemen yang telah disortir celahnya
				// simpan [i] di temp dan buat lubang di posisi i
	        	Sortable temp = a[i];
	  
				// menggeser elemen yang diurutkan dengan celah sebelumnya hingga benar
				// lokasi untuk [i] ditemukan
				// arr [j - gap]> temp
	            int j;            
	            // Ascending(naik) -> a[j - gap].compare(temp) == 1
	            // Descending(turun) -> a[j - gap].compare(temp) == -1
	            for (j = i; j >= gap && (a[j - gap].compare(temp) == -1); j -= gap)
	                a[j] = a[j - gap];
	              
	            // assign temp (the original a[i]) di lokasi yang benar
	            a[j] = temp;
	        }
	    }
	}
}
