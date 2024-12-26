package com.napier.mlsServices.dto;

import com.napier.mlsServices.entity.Language;

public class LanguageDTO {
        private Language language;

		public LanguageDTO() {
			super();
		}
		
		public LanguageDTO(Language language) {
			super();
			this.language = language;
		}

		public Language getLanguage() {
			return language;
		}

		public void setLanguage(Language language) {
			this.language = language;
		}

		@Override
		public String toString() {
			return "RequestLang [language=" + language + "]";
		}
   
        
}
