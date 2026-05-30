//
//  AboutScreen.swift
//  iosApp
//
//  Created by Manish Kumar on 29/05/26.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle("About Device")
        }
      
    }
}

#Preview {
    AboutScreen()
}
