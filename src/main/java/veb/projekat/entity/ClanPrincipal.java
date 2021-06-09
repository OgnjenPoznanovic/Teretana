/*package veb.projekat.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ClanPrincipal implements UserDetails {

	
	private Clan clan;
	
	
	public ClanPrincipal(Clan clan) {
		this.clan = clan;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			return Collections.singleton(new SimpleGrantedAuthority("clan"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clan.getLozinka();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return clan.getKorisnicko_ime();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
*/