/*
 * This file is part of "The Java Telnet Application".
 *
 * This is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * "The Java Telnet Application" is distributed in the hope that it will be 
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this software; see the file COPYING.  If not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */
package de.mud.jta.event;

import de.mud.jta.Plugin;
import de.mud.jta.PluginMessage;
import de.mud.jta.PluginListener;

import java.awt.event.FocusEvent;

/**
 * Notify all listeners that a component has got the input focus.
 * <P>
 * <B>Maintainer:</B> Matthias L. Jugel
 *
 * @version $Id$
 * @author Matthias L. Jugel, Marcus Mei�ner
 */
public class FocusStatus implements PluginMessage {
  protected Plugin plugin;
  protected FocusEvent event;

  /** Create a new online status message with the specified value. */
  public FocusStatus(Plugin plugin, FocusEvent event) {
    this.plugin = plugin;
    this.event = event;
  }

  /**
   * Notify the listers about the focus status of the sending component.
   * @param pl the list of plugin message listeners
   * @return null
   */
  public Object firePluginMessage(PluginListener pl) {
    if(pl instanceof FocusStatusListener)
      switch(event.getID()) {
        case FocusEvent.FOCUS_GAINED:
          ((FocusStatusListener)pl).pluginGainedFocus(plugin); break;
	case FocusEvent.FOCUS_LOST:
          ((FocusStatusListener)pl).pluginLostFocus(plugin);
      }
    return null;
  }
}
